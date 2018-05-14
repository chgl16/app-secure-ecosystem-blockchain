package application;

public class KmConfig
{
    //����ip
    private String FtpHost = "";
    //�˿ں�
    private int FtpPort;
    //ftp�û���
    private String FtpUser = "";
    //ftp����
    private String FtpPassword = "";
    //ftp�е�Ŀ¼
    private String FtpPath = "";
    public String getFtpHost()
    {
        return FtpHost;
    }
    public void setFtpHost(String ftpHost)
    {
        FtpHost = ftpHost;
    }
    public int getFtpPort()
    {
        return FtpPort;
    }
    public void setFtpPort(int ftpPort)
    {
        FtpPort = ftpPort;
    }
    public String getFtpUser()
    {
        return FtpUser;
    }
    public void setFtpUser(String ftpUser)
    {
        FtpUser = ftpUser;
    }
    public String getFtpPassword()
    {
        return FtpPassword;
    }
    public void setFtpPassword(String ftpPassword)
    {
        FtpPassword = ftpPassword;
    }
    public String getFtpPath()
    {
        return FtpPath;
    }
    public void setFtpPath(String ftpPath)
    {
        FtpPath = ftpPath;
    }

}
