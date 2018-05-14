package application;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.exceptions.TransactionTimeoutException;

public class MarketModel extends useFunction implements Resourse{
	Credentials credentials;
	public int marketID;
	public String addr;
	public String name = "";
	public String registerTime;
	public int reputation;
	public String desc;
	public int repPointer;
	
	
	private static List<Type> callFunction(Function function) throws InterruptedException, ExecutionException{
		return callFunction(MarketAPI,function);
	}
	
	private static EthSendTransaction executeFunction(Credentials cred,Function function) throws InterruptedException, ExecutionException{
		return executeFunction(cred,MarketAPI,function);
	}	
	
	public static int getAppPointer(String _market) throws InterruptedException, ExecutionException {
		Function function = new Function("appPointer",
				Arrays.<Type>asList(new Address(_market)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));
		List<Type> result;
		result = callFunction(function);
		try{
			if(result.get(0).toString().equals(""))
				return 0;
		}
		catch (Exception e){
			return 0;
		}
		return Integer.parseInt(result.get(0).getValue().toString());												
	}
	
	public static Credentials Register(String password,String _name,String _desc,File path) throws InterruptedException, ExecutionException, ModelException, IOException, CipherException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException{
		String keyfilename = WalletUtils.generateFullNewWalletFile(password,path);
		Credentials cred = WalletUtils.loadCredentials(password,path.getPath()+"\\"+keyfilename);
		MarketRegister(cred,_name,_desc);
		return cred;
	}
	
	public static void MarketRegister(Credentials cred,String _name,String _desc) throws InterruptedException, ExecutionException{
		Function function = new Function("registerMarkets", 
				Arrays.<Type>asList(new Address(cred.getAddress()),new Utf8String(_name),new Utf8String(_desc)), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Bool>(){}));
		executeFunction(owner,function);
		UserModel.UserRegister(cred,1,_name,_desc);
	}
	
	
	public static int numMarkets() throws InterruptedException, ExecutionException{
		Function function = new Function("numMarkets",
				Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));
		List<Type> result = callFunction(function);
		return Integer.parseInt(result.get(0).getValue().toString());												
	}
	
	public static int getMarketRepPointer(int marketID) throws InterruptedException, ExecutionException{
		Function function = new Function("getMarketRepPointer",
				Arrays.<Type>asList(new Uint256(new BigInteger(marketID+""))),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));
		List<Type> result = callFunction(function);
		return Integer.parseInt(result.get(0).getValue().toString());												
	}	
	
	
	public static MarketModel getMarket(int marketID) throws InterruptedException, ExecutionException, ModelException{
		Function function = new Function("getMarket",
				Arrays.<Type>asList(new Uint256(new BigInteger(marketID+""))),
				Arrays.<TypeReference<?>>asList(new TypeReference<Address>(){},new TypeReference<Utf8String>(){},
						new TypeReference<Uint256>(){},new TypeReference<Uint256>(){},
						new TypeReference<Utf8String>(){},new TypeReference<Uint256>(){}));
		List<Type> result = callFunction(function);
		
		//���ڼ���ȡ��Ϣ
		if(result.get(0).toString().equals(""))
			throw new ModelException("Market not found");
		
		MarketModel market = new MarketModel();
		market.marketID = marketID;
		market.addr = result.get(0).toString();
		market.name = result.get(1).toString();
		String registerTime = result.get(2).getValue().toString()+"000";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(registerTime))));   // 时间戳转换成时间
    //    System.out.println(sd);
		market.registerTime = sd;
		market.reputation = Integer.parseInt(result.get(3).getValue().toString()); 
		market.desc = result.get(4).toString();
		market.repPointer = Integer.parseInt(result.get(5).getValue().toString()); 		
		return market;
	}
	
	public static int getMarketID(String _addr) throws InterruptedException, ExecutionException, ModelException{
		Function function = new Function("markets",
				Arrays.<Type>asList(new Address(_addr)),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));
		List<Type> result = callFunction(function);
		int ID = Integer.parseInt(result.get(0).getValue().toString());
		if(ID == 0)
			throw new ModelException("market not exist.");
		return ID;
	}
	
	public static MarketModel login(String keystorepass,String keystore) throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException{
		Credentials credentials = WalletUtils.loadCredentials(keystorepass,keystore);			
		return login(credentials);
	}
	
	public static MarketModel login(Credentials cred) throws InterruptedException, ExecutionException, ModelException{		
		MarketModel market = getMarket(getMarketID(cred.getAddress()));	
		market.credentials = cred;
		return market;
	}
	
	public void marketModifyName(String _name) throws InterruptedException, ExecutionException{
		Function function = new Function("marketModifyName", 
				Arrays.<Type>asList(new Utf8String(_name)), 
				Arrays.<TypeReference<?>>asList());
		executeFunction(credentials,function);
	}

	public void marketModifyDesc(String _desc) throws InterruptedException, ExecutionException{
		Function function = new Function("marketModifyDesc", 
				Arrays.<Type>asList(new Utf8String(_desc)), 
				Arrays.<TypeReference<?>>asList());
		executeFunction(credentials,function);
	}
	
/*	public static void feedback(int marketID,int repChange) throws InterruptedException, ExecutionException{
		Function function = new Function("feedback",
				Arrays.<Type>asList(new Uint256(new BigInteger(marketID+"")),new Uint256(new BigInteger(repChange+""))),
				Arrays.<TypeReference<?>>asList());
		executeFunction(owner,function);
	}		*/

/*	public void updateRepPointer(int marketID,int _repPointer) throws InterruptedException, ExecutionException{
		Function function = new Function("updateRepPointer",
				Arrays.<Type>asList(new Uint256(new BigInteger(marketID+"")),new Uint256(new BigInteger(_repPointer+""))),
				Arrays.<TypeReference<?>>asList());
		EthSendTransaction transactionResponse = executeFunction(credentials,function);
        System.out.println(transactionResponse.getResult());
	}	//	*///0xb70dc1f72766ebff006f6277e0931263bbc7f141104e9568bb169281988bc53f

}
