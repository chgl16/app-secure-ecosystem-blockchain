package application;

import java.io.IOException;
import java.math.BigInteger;
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
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.exceptions.TransactionTimeoutException;

public class TransactionModel extends useFunction implements Resourse{
	public int ID = 0;
	public String market;
	public String apkhash = "";
	public String name = "";
	public String tratime = "";
	public String developer = "";
	public Boolean alive; 
	public Boolean accept;
	public Boolean feedback;
	public Boolean deal;
	public int repPointer_market_pre;
	public int repPointer_market_next;
	public int repPointer_dev_pre;
	public int repPointer_dev_next;
	public int appPointer = 0;
	
	
	private static List<Type> callFunction(Function function) throws InterruptedException, ExecutionException{
		return callFunction(TransactionAPI,function);
	}
	
/*	private static List<Type> callFunction(Credentials cred,Function function) throws InterruptedException, ExecutionException{
		return callFunction(cred,TransactionAPI,function);
	}*/
	
	private static EthSendTransaction executeFunction(Credentials cred,Function function) throws InterruptedException, ExecutionException{
		return executeFunction(cred,TransactionAPI,function);
	}
	
	
	public static int numTras() throws InterruptedException, ExecutionException{
		Function function = new Function("numTras",
				Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));			
		List<Type> result = callFunction(function);
		return Integer.parseInt(result.get(0).getValue().toString());												
	}
	
	public static TransactionModel getTras(int trasID) throws InterruptedException, ExecutionException, ModelException{
		if(trasID>=numTras()) 
			throw new ModelException("trasID out of range.");
	
		Function function = new Function("getTras",
				Arrays.<Type>asList(new Uint256(new BigInteger(trasID+""))),
				Arrays.<TypeReference<?>>asList(new TypeReference<Address>(){},new TypeReference<Utf8String>(){},new TypeReference<Utf8String>(){},
						new TypeReference<Uint256>(){},new TypeReference<Address>(){},
						new TypeReference<Bool>(){},new TypeReference<Uint256>(){}));
		List<Type> result = callFunction(function);
		
		//���ڼ���ȡ��Ϣ
		try{
			if(result.get(0).toString().equals(""))
				throw new ModelException("Transaction not found");
		}
		catch (Exception e){
			throw new ModelException("Transaction not found");
		}
		
		TransactionModel tras = new TransactionModel();
		tras.ID = trasID;
		tras.market=result.get(0).toString();
		tras.apkhash=result.get(1).toString();
		tras.name=result.get(2).toString();
		String registerTime = result.get(3).getValue().toString()+"000";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(registerTime))));   // 时间戳转换成时间
     //   System.out.println(sd);
		tras.tratime = sd;
		tras.developer=result.get(4).toString(); 
		tras.accept = (Boolean) result.get(5).getValue();
		tras.appPointer = Integer.parseInt(result.get(6).getValue().toString());
		return tras;
	}
	
	public static TransactionModel getNextApp(int next_tra) throws InterruptedException, ExecutionException, ModelException{
		TransactionModel t = getTras(next_tra);
		while(!t.accept||isfeedback(next_tra)||!isalive(next_tra)){
			if(next_tra == 0) throw new ModelException("no app");
			next_tra = t.appPointer;
			t = getTras(next_tra);
			System.out.println(next_tra);
		}
		return t;
	}
	
	public static TransactionModel getNextUntreatedTras(int next_tra) throws InterruptedException, ExecutionException, ModelException{
		if(next_tra == 0) return new TransactionModel();
		TransactionModel t = getTras(next_tra);
		while(TransactionModel.isdeal(next_tra)){
			if(next_tra == 0) return new TransactionModel();
			next_tra = t.appPointer;
			t = getTras(next_tra);
			System.out.println(next_tra);
		}
		if(t.ID == 0)
			return new TransactionModel();
		return t;		
	}
	
	public static TransactionModel getNextIsdealTras(int next_tra) throws InterruptedException, ExecutionException, ModelException{
		if(next_tra == 0) return new TransactionModel();
		TransactionModel t = getTras(next_tra);
		while(!TransactionModel.isdeal(next_tra)){
			if(next_tra == 0) return new TransactionModel();
			next_tra = t.appPointer;
			t = getTras(next_tra);
			System.out.println(next_tra);
		}
		return t;		
	}
	
	public static TransactionModel getTrasMarketRepPointer(int trasID) throws InterruptedException, ExecutionException, ModelException{
		if(trasID>=numTras()) 
			throw new ModelException("trasID out of range.");
	
		Function function = new Function("getTrasMarketRepPointer",
				Arrays.<Type>asList(new Uint256(new BigInteger(trasID+""))),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){},new TypeReference<Uint256>(){}));
		List<Type> result = callFunction(function);
		
		//���ڼ���ȡ��Ϣ
		if(result.get(0).toString().equals(""))
			throw new ModelException("Transaction not found");
		
		TransactionModel tras = new TransactionModel();
		tras.repPointer_market_pre=Integer.parseInt(result.get(0).getValue().toString());
		tras.repPointer_market_next=Integer.parseInt(result.get(1).getValue().toString());
		return tras;
	}
	
	public static TransactionModel getTrasDevRepPointer(int trasID) throws InterruptedException, ExecutionException, ModelException{
		if(trasID>=numTras()) 
			throw new ModelException("trasID out of range.");
	
		Function function = new Function("getTrasDevRepPointer",
				Arrays.<Type>asList(new Uint256(new BigInteger(trasID+""))),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){},new TypeReference<Uint256>(){}));
		List<Type> result = callFunction(function);
		
		//���ڼ���ȡ��Ϣ
		if(result.get(0).toString().equals(""))
			throw new ModelException("Transaction not found");
		
		TransactionModel tras = new TransactionModel();
		tras.repPointer_dev_pre=Integer.parseInt(result.get(0).getValue().toString());
		tras.repPointer_dev_next=Integer.parseInt(result.get(1).getValue().toString());
		return tras;
	}
	
	public static void Upload(String _apkhash,String _name,String _market,Credentials cred) throws InterruptedException, ExecutionException{
		Function function = new Function("Upload", 
				Arrays.<Type>asList(new Utf8String(_apkhash),new Utf8String(_name),new Address(_market)), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));
		EthSendTransaction transactionResponse = executeFunction(cred,function);
        System.out.println(transactionResponse.getResult());
	}
	
	public static void feedback(int trasID,String _market,Credentials cred) throws InterruptedException, ExecutionException, ModelException{
		if(trasID>=numTras()) 
			throw new ModelException("trasID out of range.");
	
		Function function = new Function("feedback", 
				Arrays.<Type>asList(new Uint256(new BigInteger(trasID+"")),new Address(_market)), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));
		EthSendTransaction transactionResponse = executeFunction(cred,function);
        System.out.println(transactionResponse.getResult());
	}
	
	public static Boolean isalive(int trasID) throws InterruptedException, ExecutionException, ModelException{
		if(trasID>=numTras()) 
			throw new ModelException("trasID out of range.");
	
		Function function = new Function("isalive", 
				Arrays.<Type>asList(new Uint256(new BigInteger(trasID+""))), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Bool>(){}));
		List<Type> result = callFunction(function);
		return (Boolean) result.get(0).getValue();												
	}
	
	public static Boolean isaccept(int trasID) throws InterruptedException, ExecutionException, ModelException{
		if(trasID>=numTras()) 
			throw new ModelException("trasID out of range.");
	
		Function function = new Function("isaccept", 
				Arrays.<Type>asList(new Uint256(new BigInteger(trasID+""))), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Bool>(){}));
		List<Type> result = callFunction(function);
		return (Boolean) result.get(0).getValue();												
	}
	
	public static Boolean ismalicious(String _apkhash) throws InterruptedException, ExecutionException{
		Function function = new Function("ismalicious", 
				Arrays.<Type>asList(new Utf8String(_apkhash)), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Bool>(){}));
		List<Type> result = callFunction(function);
		return (Boolean) result.get(0).getValue();												
	}
	
	public static int getRepChange(String _apkhash) throws InterruptedException, ExecutionException{
		Function function = new Function("getRepChange", 
				Arrays.<Type>asList(new Utf8String(_apkhash)), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){}));
		List<Type> result = callFunction(function);
		return Integer.parseInt(result.get(0).getValue().toString());												
	}
	
	public static void deal(int trasID,Credentials cred,Boolean deal) throws InterruptedException, ExecutionException, ModelException{
		if(trasID>=numTras()) 
			throw new ModelException("trasID out of range.");		
	
		Function function = new Function("deal", 
				Arrays.<Type>asList(new Uint256(new BigInteger(trasID+"")),new Bool(deal)), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Bool>(){}));
        EthSendTransaction transactionResponse = executeFunction(cred,function);
        System.out.println(transactionResponse.getResult());												
	}

	public static Boolean isdeal(int trasID) throws InterruptedException, ExecutionException, ModelException{
		if(trasID>=numTras()) 
			throw new ModelException("trasID out of range.");
	
		Function function = new Function("isdeal", 
				Arrays.<Type>asList(new Uint256(new BigInteger(trasID+""))), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Bool>(){}));
		List<Type> result = callFunction(function);
		return (Boolean) result.get(0).getValue();												
	}
	
	public static Boolean isfeedback(int trasID) throws InterruptedException, ExecutionException, ModelException{
		if(trasID>=numTras()) 
			throw new ModelException("trasID out of range.");
	
		Function function = new Function("isfeedback", 
				Arrays.<Type>asList(new Uint256(new BigInteger(trasID+""))), 
				Arrays.<TypeReference<?>>asList(new TypeReference<Bool>(){}));
		List<Type> result = callFunction(function);
		return (Boolean) result.get(0).getValue();												
	}
	
}
