package cn.mldn.dibmp.util;



import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

public class FileTokenUtil {
	public static void main(String[] args) throws Exception {
		//通过ClassPath路径获取要使用的配置文件，实现资源定位
		ClassPathResource classPathResource = new ClassPathResource("fastdfs.properties");
		//进行客户端访问的整体配置，需要知道配置文件的完整路径
		ClientGlobal.init(classPathResource.getClassLoader().getResource("fastdfs.properties").getPath());
		//fastDFS的核心操作在于Tracker处理上，所有此时需要定义Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		//定义TrackerServer的配置信息
		TrackerServer trackerServer = trackerClient.getConnection();
		//设置的是文件路径，但是这个路径钱是没有组的
		String fileUrl = "M00/00/00/wKi4vVoB0hSAPRzSAAEUABmXid4170.gif";
		//要生成一个token ，这个token是有时间效应的，所以应该利用时间处理
		int ts = (int)(System.currentTimeMillis()/1000);
		StringBuffer accessUrl = new StringBuffer(fileUrl);
		accessUrl.append("http://");
		accessUrl.append(trackerServer.getInetSocketAddress().getHostString());
		accessUrl.append("/group1/").append(fileUrl);
		accessUrl.append("?token=").append(ProtoCommon.getToken(fileUrl, ts, ClientGlobal.g_secret_key));
		accessUrl.append("&ts=").append(ts);
		System.err.println(accessUrl);
		trackerServer.close();
		
	}
}
