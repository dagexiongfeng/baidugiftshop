package baidu.giftshop.frk;

import java.awt.image.BufferedImage;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.InputStream;  
import java.text.ParseException;  

import baidu.giftshop.entity.Goods;
import baidu.giftshop.entity.GoodsPicture;
import baidu.giftshop.util.HibernateSessionFactory;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;  
import org.apache.struts2.ServletActionContext;  
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;  
  
@SuppressWarnings({ "restriction" })
public class UploadDAO {  
      
	//上传用  
    private File pic;
    private String picFileName;
    private String picContentType; 
    private InputStream inputStream;
    private Double radio;
    //private Integer briefgoods;
    
	Session session = HibernateSessionFactory.getSession();
              
    /** 
     * 功能：文件上传,并把路径添加到数据库中
     * @author fengjun01
     * @return 跳转页面的字符串 
     * @throws IOException 
     * @throws ParseException 
     */  
    public String upload(File pic,String picFileName,Integer briefgoods){  
    	
    	String name = picFileName.substring(picFileName.lastIndexOf(".")); // 得到后缀名
    	if (name.equals(".jpg") || name.equals(".gif") || name.equals(".png")|| name.equals(".jpeg")|| name.equals(".JPG")) { 
    		 try {
    			 String path = ServletActionContext.getServletContext().getRealPath("");
 				 String realpath = path.substring(0, path.lastIndexOf("\\"))+"\\Original";
    		    // String realpath = ServletActionContext.getServletContext().getRealPath("/Original");
				 InputStream input = new FileInputStream(pic);
				 BufferedImage bi = ImageIO.read(input);
				 double width = bi.getWidth(); // 上传图片的宽
	             double height = bi.getHeight(); // 上传图片的高
	             double radio = width/height;
	             System.out.println("宽：" + width + "\t高：" + height +"\t比例：" + radio);
				 if (bi != null && width==height && 480 < width) { // 如果图片正确则不为空，不正确时为空
		               
		                String FileName = System.currentTimeMillis() + picFileName;
		                if (this.htmlUpload(pic, realpath,FileName)) {
		                    System.out.println("上传成功！");
		                    UploadDAO.uploadJPGfile(bi, FileName,radio);
		                    
		                    //插入图片的路径到GoodsPicture里
		                    Transaction tr = session.beginTransaction();
		                    GoodsPicture goodspicture = new GoodsPicture();
		                    Goods goods = (Goods) session.get(Goods.class, briefgoods);
		                    goodspicture.setGoods(goods);
		                    goodspicture.setPath("/Original/"+FileName);
		                    goodspicture.setThumbPath("/Thumb/"+FileName);
		                    goodspicture.setRatio(radio);
		                    session.saveOrUpdate(goodspicture);
		                    tr.commit();
		                    
		                } else {
		                    System.out.println("上传失败！");
		                    deleteGoods(briefgoods);
		                    return "error";
		                }
		            } else {
		                System.out.println("你选择的图片错误或者该图片已经损坏！"); // 给出提示
		                deleteGoods(briefgoods);
		                return "error";
		            }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
        return "success";  
    } 
    /**
     * 删除插入进数据的Goods类型
     */
    public void deleteGoods(Integer briefgoods){
    	Transaction tr = session.beginTransaction();
        Goods goods = (Goods) session.get(Goods.class, briefgoods);
        session.delete(goods);
        tr.commit();
    }
    /**
     * 按比例压缩图，然后上传到服务器的Thumb文件夹内
     * @param bi
     * @param FileName
     * @param radio
     * @return
     */
    private static boolean uploadJPGfile(BufferedImage bi, String FileName,double radio) {
    	try {
            // 转为jpg标准格式//
            //String realpath = ServletActionContext.getServletContext().getRealPath("/Thumb");
    		String path = ServletActionContext.getServletContext().getRealPath("");
			String realpath = path.substring(0, path.lastIndexOf("\\"))+"\\Thumb";
            if (bi != null) {
                int new_w = 120;
                int new_h = (int) (new_w/radio);
                BufferedImage tag = new BufferedImage(new_w, new_h,BufferedImage.TYPE_INT_RGB);
                tag.getGraphics().drawImage(bi, 0, 0, new_w, new_h, null); // 绘制缩小后的图
                File file = new File(new File(realpath), FileName);
                if (!file.getParentFile().exists())   
                    file.getParentFile().mkdirs();  
                FileOutputStream out = new FileOutputStream(file);
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                encoder.encode(tag);
                out.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("异常错误！");
            System.out.println(e.getMessage());
            return false;
        }
	}
    /**
     * 上传原图到服务器的Original的文件夹内
     * @param pic
     * @param realpath
     * @param FileName
     * @return
     */
	private boolean htmlUpload(File pic, String realpath,String FileName) {
		try {  
            /*服务器的路径  
            System.out.println("上传到服务器的地址realpath: "+realpath);  
            int random = (int) (Math.random() * 10000); // 随机数
            String name = pic.getName();
            String FileName = System.currentTimeMillis() + picFileName;  
		               具体地址+文件名  
	        String lj = realpath+"\\"+ FileName;
            System.out.println("具体的地址lujing"+lj);  */
            if (pic != null) {              
                File savefile = new File(new File(realpath), FileName);              
                if (!savefile.getParentFile().exists())   
                    savefile.getParentFile().mkdirs();    
                FileUtils.copyFile(pic, savefile);              
                ActionContext.getContext().put("message", "文件上传成功"); 
            }  
            return true;
        } catch (IOException e) {  
            e.printStackTrace();  
            return false;
        } catch (Exception e) {  
            e.printStackTrace();
            return false;
        } 
	}
		
  
    public File getPic() {  
        return pic;  
    }  
    
    public void setPic(File pic) {  
        this.pic = pic;  
    }  
  
    public String getPicFileName() {  
        return picFileName;  
    }  
  
    public void setPicFileName(String picFileName) {  
        this.picFileName = picFileName;  
    }  
  
    public String getPicContentType() {  
        return picContentType;  
    }  
  
    public void setPicContentType(String picContentType) {  
        this.picContentType = picContentType;  
    }  
  
    public InputStream getInputStream() {  
        return inputStream;  
    }  
  
    public void setInputStream(InputStream inputStream) {  
        this.inputStream = inputStream;  
    }  

    public Double getRadio() {
		return radio;
	}
    
	public void setRadio(Double radio) {
		this.radio = radio;
	}
	
//	public Integer getBriefgoods() {
//		return briefgoods;
//	}
//	
//	public void setBriefgoods(Integer briefgoods) {
//		this.briefgoods = briefgoods;
//	}
}  
