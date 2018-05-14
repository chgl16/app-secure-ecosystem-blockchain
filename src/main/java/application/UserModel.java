package application;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Struct;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.RawTransaction;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.exceptions.TransactionTimeoutException;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;
import org.web3j.utils.Strings;


public class UserModel extends useFunction implements Resourse{
	Credentials credentials;
	public String addr = "";
	public String name = "";
	public String registerTime = "";
	public int reputation = 0;
	public String desc;
	public int repPointer;
	public String userType;
	
	
	private static List<Type> callFunction(Function function) throws InterruptedException, ExecutionException{
		return callFunction(UserAPI,function);
	}
	
	private static EthSendTransaction executeFunction(Credentials cred,Function function) throws InterruptedException, ExecutionException{
		return executeFunction(cred,UserAPI,function);
	}			
		
		
	public static int numUsers() throws InterruptedException, ExecutionException{
		Function function = new Function("numUsers",
				Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));			
		List<Type> result = callFunction(function);
		return Integer.parseInt(result.get(0).getValue().toString());												
	}

	public static int quota() throws InterruptedException, ExecutionException{
		Function function = new Function("quota",
				Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));
		List<Type> result = callFunction(function);
		return Integer.parseInt(result.get(0).getValue().toString());												
	}
		
		
	public static Credentials Register(String password,int _userType,String _name,String _desc,File path) throws ModelException, InterruptedException, ExecutionException, IOException, CipherException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException{
		if(_userType!=0&&_userType!=1)
			throw new ModelException("userType not correct.");
		String keyfilename = WalletUtils.generateFullNewWalletFile(password,path);
		Credentials cred = WalletUtils.loadCredentials(password,path.getPath()+"\\"+keyfilename);
		UserRegister(cred,_userType,_name,_desc);
		return cred;
	}
	
	public static void UserRegister(Credentials cred,String _userType,String _name,String _desc) throws InterruptedException, ExecutionException, ModelException{
		int _userType1 = 1;
		if(_userType.equals("user"))
			_userType1 = 0;
		else if(!_userType.equals("developer"))
			throw new ModelException("userType not correct.");
		UserRegister(cred,_userType1,_name,_desc);
	}
	
	public static void UserRegister(Credentials cred,int _userType,String _name,String _desc) throws InterruptedException, ExecutionException{
		Function function = new Function("RegisterUser", 
				Arrays.<Type>asList(new Address(cred.getAddress()),new Utf8String(_name),new Utf8String(_desc),new Uint256(new BigInteger(_userType+""))),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));

        EthSendTransaction transactionResponse = executeFunction(owner1,function);
        System.out.println(transactionResponse.getResult());				
	}

	public static UserModel getUserByAddress(String _addr) throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException{
		//Ҫ���ú���������
		Function function = new Function("getUserByAddress", 
				Arrays.<Type>asList(new Address(_addr)), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(){},
						new TypeReference<Uint256>(){},new TypeReference<Uint256>(){},
						new TypeReference<Uint256>(){},new TypeReference<Uint256>(){},
						new TypeReference<Utf8String>(){}));
		
		List<Type> result = callFunction(function);
		
		//�������ȡ��Ϣ
		if(result.get(0).toString().equals(""))
			throw new ModelException("User not found");
		UserModel user = new UserModel();
		user.addr=_addr;
		user.name=result.get(0).toString();
		String registerTime = result.get(1).getValue().toString()+"000";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(registerTime))));   // 时间戳转换成时间
    //    System.out.println(sd);
		user.registerTime = sd;
		user.reputation=Integer.parseInt(result.get(2).getValue().toString()); 
		int _userType = Integer.parseInt(result.get(3).getValue().toString());
		if(_userType == 0)
			user.userType = "user";
		else user.userType = "developer";
		user.repPointer = Integer.parseInt(result.get(4).getValue().toString());
		user.desc=result.get(5).toString();
		return user;
	}
	
	public static UserModel login(String keystorepass,String keystore) throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException{
		Credentials credentials = WalletUtils.loadCredentials(keystorepass,keystore);			
		return login(credentials);
	}
			
	public static UserModel login(Credentials _credentials) throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException{
		UserModel user = getUserByAddress(_credentials.getAddress());
		user.credentials = _credentials;		
		return user;
	}
	
	public static UserModel logout(){
		return new UserModel();
	}
	
	public static int getUserRepPointer(String addr) throws InterruptedException, ExecutionException{
		Function function = new Function("getUserRepPointer", 
				Arrays.<Type>asList(new Address(addr)), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));
		List<Type> result = callFunction(function);
		return Integer.parseInt(result.get(0).getValue().toString());		
	}
	
	public void userModifyName(String _name) throws InterruptedException, ExecutionException{
		Function function = new Function("userModifyName", 
				Arrays.<Type>asList(new Utf8String(_name)), 
				Arrays.<TypeReference<?>>asList());
    
		EthSendTransaction transactionResponse = executeFunction(credentials,function);
        System.out.println(transactionResponse.getResult());
	}
	
	public void userModifyDesc( String _desc) throws InterruptedException, ExecutionException{
		Function function = new Function("userModifyDesc", 
				Arrays.<Type>asList(new Utf8String(_desc)), 
				Arrays.<TypeReference<?>>asList());
    
		EthSendTransaction transactionResponse = executeFunction(credentials,function);
        System.out.println(transactionResponse.getResult());
	}
	
/*	public static void feedback(String _addr,int repChange) throws InterruptedException, ExecutionException{
		Function function = new Function("feedback",
				Arrays.<Type>asList(new Address(_addr),new Uint256(new BigInteger(repChange+""))),
				Arrays.<TypeReference<?>>asList());
    
		EthSendTransaction transactionResponse = executeFunction(owner,function);
        System.out.println(transactionResponse.getResult());
	}
	
	public static void updateRepPointer(String _addr,int _repPointer) throws InterruptedException, ExecutionException{
		Function function = new Function("updateRepPointer",
				Arrays.<Type>asList(new Address(_addr),new Uint256(new BigInteger(_repPointer+""))),
				Arrays.<TypeReference<?>>asList());
    
		EthSendTransaction transactionResponse = executeFunction(owner,function);
        System.out.println(transactionResponse.getResult());
	}*/
}
