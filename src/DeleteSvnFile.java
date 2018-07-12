import java.io.*;


public class DeleteSvnFile {
	/**
     * 删除文件夹中所有的.svn文件夹
     */
    public static void main(String[] args) throws Exception{
        
        //1. 读取要删除的目录
        String parentPath = "D:\\pinyougou";
        File file =new File(parentPath);
        //2. 删除文件
        
        deleteFile(file,".svn");

    }
    
    private static void deleteFile(File file,String deleteFileName){
        
        if(file.isDirectory()){
            
            if(deleteFileName.equals(file.getName())){
                //老版本的svn，记录信息比较怪
                deleteSvnFile(file);
            }else{
                File[] fileArray =file.listFiles();
                for(File fileItem: fileArray){
                    deleteFile(fileItem,deleteFileName);
                }
            }
            
        }
    }
    
    /**
     * 老版本的svn信息，它的文件夹下是有很多子目录的，必须删除子目录，才能删除它本身
     * @param file
     */
    private static void deleteSvnFile(File file){
        File[] fileArray =file.listFiles();
        for(File fileItem: fileArray){
            if(fileItem.isFile()){
                System.out.println("删除-->"+fileItem.getAbsolutePath());
                fileItem.delete();
            }else{
                deleteSvnFile(fileItem);
            }
        }
        System.out.println("删除-->"+file.getAbsolutePath());
        file.delete();
    }
    
    
}
