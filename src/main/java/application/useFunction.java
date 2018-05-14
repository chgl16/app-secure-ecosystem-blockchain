package application;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.bouncycastle.jcajce.provider.digest.SHA256;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.RawTransaction;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.utils.Numeric;


//��Լ�������÷�ʽ
public class useFunction{
	//���ɽ���
	public static EthSendTransaction executeFunction(Credentials cred, String contract, Function function) throws InterruptedException, ExecutionException{
	
		EthGetTransactionCount ethGetTransactionCount = Resourse.web3j.ethGetTransactionCount(
				cred.getAddress(), DefaultBlockParameterName.LATEST).sendAsync().get();
		BigInteger nonce = ethGetTransactionCount.getTransactionCount();
		
	//	nonce = nonce.add(new BigInteger(10+""));
		System.out.println("nonce:"+nonce);
		String encodedFunction = FunctionEncoder.encode(function);
		
		EthGasPrice ethGasPrice = Resourse.web3j.ethGasPrice().sendAsync().get();
		//create&sign Transaction
		RawTransaction rawTransaction=RawTransaction.createTransaction(nonce, ethGasPrice.getGasPrice(), new BigInteger(2000000+""),contract, encodedFunction);
		byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, cred);
	    String hexValue = Numeric.toHexString(signedMessage);
	    
	    //send&response
	    EthSendTransaction transactionResponse = Resourse.web3j.ethSendRawTransaction(hexValue)
	            .sendAsync().get();
		return transactionResponse;
	}
	
	//��ѯ����
	public static List<Type> callFunction(String contract, Function function) throws InterruptedException, ExecutionException{
		String encodedFunction = FunctionEncoder.encode(function);
		EthCall res = Resourse.web3j.ethCall(
			Transaction.createEthCallTransaction(contract, encodedFunction),DefaultBlockParameterName.LATEST)
			.sendAsync().get();
		List<Type> result = FunctionReturnDecoder.decode(
	             res.getValue(), function.getOutputParameters());
		return result;
	}
	

/*	public static List<Type> callFunction(Credentials cred,String contract, Function function) throws InterruptedException, ExecutionException{
		// get the next available nonce
		EthGetTransactionCount ethGetTransactionCount = Resourse.web3j.ethGetTransactionCount(
				cred.getAddress(), DefaultBlockParameterName.LATEST).sendAsync().get();
		BigInteger nonce = ethGetTransactionCount.getTransactionCount();
		System.out.println("nonce:"+nonce);

		
		String encodedFunction = FunctionEncoder.encode(function);
		EthCall res = Resourse.web3j.ethCall(
			Transaction.createFunctionCallTransaction(cred.getAddress(),
					nonce,BigInteger.valueOf(1308731), BigInteger.valueOf(1308731),contract, encodedFunction),
					DefaultBlockParameterName.LATEST).sendAsync().get();
		List<Type> result = FunctionReturnDecoder.decode(
	             res.getValue(), function.getOutputParameters());
		return result;
	}*/
}
