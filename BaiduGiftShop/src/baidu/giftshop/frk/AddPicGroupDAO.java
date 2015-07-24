package baidu.giftshop.frk;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import baidu.giftshop.entity.GoodsDetai;
import baidu.giftshop.entity.GoodsDetailPicture;
import baidu.giftshop.util.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class AddPicGroupDAO {
	
	//上传用  
    private String picContentType;  
    private InputStream inputStream; 
    private Double radio;

	Session session = HibernateSessionFactory.getSession();
              
    /** 
     * 功能：文件上传,并把路径添加到数据库中
     * @author fengjun01 
     * @return 跳转页面的字符串 
     * @throws IOException 
     * @throws ParseException 
     */  
    public String upload(File pic,String picFileName,Integer groupId){  
    	
    	String name = picFileName.substring(picFileName.lastIndexOf(".")); // 得到后缀名
    	if (name.equals(".jpg") || name.equals(".gif") || name.equals(".png")|| name.equals(".jpeg")) { 
    		 try {
				String path = ServletActionContext.getServletContext().getRealPath("");
				String realpath = path.substring(0, path.lastIndexOf("\\"))+"\\Original";
				//String realpath = ServletActionContext.getServletContext().getRealPath("/Original");
				System.out.println("服务器的路径是：------"+realpath);
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
		                    AddPicGroupDAO.uploadJPGfile(bi, FileName,radio);
		                    
		                    //插入图片的路径到GoodsPicture里
		                    Transaction tr = session.beginTransaction();
		                    GoodsDetailPicture goodsdetailpicture = new GoodsDetailPicture();
		                    goodsdetailpicture.setGroupId(groupId);
		                    goodsdetailpicture.setPath("Original/"+FileName);
		                    goodsdetailpicture.setThumbPath("Thumb/"+FileName);
		                    goodsdetailpicture.setRatio(radio);
		                    session.save(goodsdetailpicture);
		                    tr.commit();
		                } else {
		                    System.out.println("上传失败！");
		                    //deleteGoods(groupId);
		                    return "error";
		                }
		            } else {
		                System.out.println("你选择的图片错误或者该图片已经损坏！"); // 给出提示
		               // deleteGoods(groupId);
		                return "error";
		            }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 return "success";
    	}else{
    		return "error";
    	}
        
    } 
    /**
     * 删除插入进数据的Goods类型
     */
    @SuppressWarnings("unchecked")
	public void deleteGoods(Integer groupId){
    	Session session = HibernateSessionFactory.getSession();
    	Transaction tr = session.beginTransaction();
    	String sql = "select gd from GoodsDetai gd where gd.picGroupId=?";
    	Query q = session.createQuery(sql);
    	q.setParameter(0, groupId);
    	List<GoodsDetai> list = q.list();
    	for(GoodsDetai goodsdetai : list){
           session.delete(goodsdetai);
    	}
        tr.commit();
        session.close();
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
  /**
   * 返回最大的组号
   * @return
   */
	public Integer queryGroupId(){
		 Integer groupId;
		 Transaction tr = session.beginTransaction();
		 String sql ="select max(groupId) from GoodsDetailPicture";
         Query q = session.createQuery(sql);
         if(q.list().get(0)!=null){
        	 groupId = (Integer) q.list().get(0);
        	 tr.commit();
         }else{
        	 groupId=0;
         }
		 return groupId;
	}
	
	/**
	 * 列出所有的GoodsDetailPicture中的组Id
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Integer> listGroupId(){
		String sql = "select distinct groupId from GoodsDetailPicture";
		Query q = session.createQuery(sql);
		List<Integer> list = q.list();
		return list;
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

}
