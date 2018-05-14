package application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
 
public class ftpclient {
	/** FTPクライアント */
	private FTPClient client = new FTPClient();
	/**
	 * @param client FTPクライアント
	 */
	public void setClient(FTPClient client) {
		this.client = client;
	}
 
	/**
	 * ロガー
	 */
	private static Logger logger = Logger.getLogger(ftpclient.class);
 
	/**
	 * FTPサーバに接続する
	 * @param hostname ホストネーム
	 * @param user FTPサーバユーザー名
	 * @param pass FTPサーバパスワード
	 * @param enc  FTPサーバエンコード用文字コード
	 * @return true:成功
	 */
	public boolean connect(String hostname, String user, String pass) {
		try {
			// encoding設定
			// FTPサーバーへ接続
			client.connect(hostname);
			// 正常に接続できたかを判定する
			if (!FTPReply.isPositiveCompletion(client.getReplyCode())) {
				throw new IOException("Ftp not Connected ReplyCode="
						+ client.getReplyCode());
			}
			// ログイン処理
			if (!client.login(user, pass)) {
				throw new IOException("login failed");
			}
			// PASVモードに設定
			client.enterLocalPassiveMode();
			// バイナリ方式に変更
			client.setFileType(FTP.BINARY_FILE_TYPE);
			return true;
		} catch (IOException e) {
			logger.info(ExceptionUtils.getStackTrace(e));
			return false;
		}
	}
 
	/**
	 * FTPサーバからログアウトする
	 * @return true:成功
	 */
	public boolean close() {
		try {
			if (client != null && client.isConnected()) {
				// FTPサーバーからログアウト
				client.logout();
				// FTPサーバーから切断
				client.disconnect();
			}
			return true;
		} catch (IOException e) {
			logger.info(ExceptionUtils.getStackTrace(e));
			return false;
		}
	}
 
	/**
	 * FTPサーバからファイルを取得する
	 * @param srcDirName FTPのディレクトリ名
	 * @param srcFileName FTPのファイル名
	 * @param destDirName 保存先ディレクトリ名
	 * @param destFileName 保存先ファイル名
	 * @return 成否
	 */
	public boolean get(String srcDirName, String srcFileName, String destDirName, String destFileName) {
		boolean result;
 
		// ファイルを指定
		File dest = new File(destDirName + "/" + destFileName);
 
		try (FileOutputStream out = new FileOutputStream(dest)) {
			// ファイルを取得
			String srcFullPath = srcDirName + "/" + srcFileName;
			// バッファサイズを1MBに
			client.setBufferSize(1024 * 1024);
			result = client.retrieveFile(srcFullPath, out);
			if (!result) {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
 
		return result;
	}
 
	/**
	 * FTPサーバにファイルを保存する
	 * @param srcDirName ディレクトリ名
	 * @param srcFileName ファイル名
	 * @param destDirName FTPの保存先ディレクトリ名
	 * @param destFileName FTPの保存先ファイル名
	 * @return 成否
	 */
	public boolean put(String srcDirName, String srcFileName, String destDirName, String destFileName) {
		boolean result;
 
		// ファイルを指定
		File source = new File(srcDirName + "/" + srcFileName);
 
		try (FileInputStream in = new FileInputStream(source)) {
			// ファイルを送信
			result = client.storeFile(destDirName + "/" + destFileName, in);
		} catch (IOException e) {
			return false;
		}
 
		return result;
	}
	    public static void delete(String server,int port,String user,String pass,String fileToDelete) {
	 
	        FTPClient ftpClient = new FTPClient();
	        try {
	 
	            ftpClient.connect(server, port);
	 
	            int replyCode = ftpClient.getReplyCode();
	            if (!FTPReply.isPositiveCompletion(replyCode)) {
	                System.out.println("Connect failed");
	                return;
	            }
	 
	            boolean success = ftpClient.login(user, pass);
	 
	            if (!success) {
	                System.out.println("Could not login to the server");
	                return;
	            }
	 
	            boolean deleted = ftpClient.deleteFile(fileToDelete);
	            if (deleted) {
	                System.out.println("The file was deleted successfully.");
	            } else {
	                System.out.println("Could not delete the  file, it may not exist.");
	            }
	 
	        } catch (IOException ex) {
	            System.out.println("Oh no, there was an error: " + ex.getMessage());
	            ex.printStackTrace();
	        } finally {
	            // logs out and disconnects from server
	            try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.logout();
	                    ftpClient.disconnect();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
 
	/**
	 * ファイルの存在確認
	 * @param srcDirName ディレクトリ名
	 * @param srcFileName ファイル名
	 * @return true: 存在する
	 */
	public boolean exists(String srcDirName, String srcFileName) {
		// ファイルを指定
		try {
			FTPFile[] files = client.listFiles(srcDirName + "/" + srcFileName);
			return files.length != 0;
		} catch (IOException e) {
			return false;
		}
	}
	
	private static String getFileChecksum(MessageDigest digest, File file) throws IOException
	{

		FileInputStream fis = new FileInputStream(file);
		
		byte[] byteArray = new byte[1024];
		int bytesCount = 0; 
		 

		while ((bytesCount = fis.read(byteArray)) != -1) {
			digest.update(byteArray, 0, bytesCount);
		};
		

		fis.close();
		

		byte[] bytes = digest.digest();
		

		StringBuilder sb = new StringBuilder();
		for(int i=0; i< bytes.length ;i++)
		{
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		
	   return sb.toString();
	}
	/**
	 * FTPサーバのファイルサイズを取得する
	 * 返り値は「byte」単位
	 * @param srcDirName ディレクトリ名
	 * @param srcFileName ファイル名
	 * @return fileSize ファイルサイズ
	 */
	public long getFileSize(String srcDirName, String srcFileName) {
		try {
			String fullPath = srcDirName + "/" + srcFileName;
			// ファイルを指定
			FTPFile[] files = client.listFiles(fullPath);
			if (files.length == 0) {
				throw new IOException("no such file : " + fullPath);
			}
			return files[0].getSize();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}