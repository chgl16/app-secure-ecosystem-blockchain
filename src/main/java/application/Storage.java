package application;

import java.io.File;
import java.util.ArrayList;

import org.web3j.crypto.Credentials;

public class Storage{
	public static Credentials credentials = Resourse.owner;
	public static UserModel user = new UserModel();
	public static MarketModel market = new MarketModel();
	public static MarketModel[] m = new MarketModel[5];
	public static int m_num = 0;
	public static TransactionModel[] t = new TransactionModel[13];
	public static int next_tras = 0;
	public static File file;
}
