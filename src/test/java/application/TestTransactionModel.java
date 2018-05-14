package application;

import static org.junit.Assert.*;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Test;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletUtils;

public class TestTransactionModel {

//	@Test
	public void testnumUsers() throws InterruptedException, ExecutionException {
		Assert.assertEquals(TransactionModel.numTras(),3);
	}
	
//	@Test
	public void testUpload() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException {
		Credentials cred = Resourse.market2;
		TransactionModel.Upload("11","11",Resourse.market3.getAddress(),cred);
	}
	
//	@Test
	public void testfeedback() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException {
		Credentials cred = WalletUtils.loadCredentials("123456", "E:\\geth\\chain1\\keystore\\"
				//	+filename);
					+"UTC--2017-05-19T14-39-52.177000000Z--3886c5143db4ad1882824adc728d0f3bd99ba3f8.json");

		TransactionModel.feedback(0,cred.getAddress(),cred);
	}
	
//	@Test
	public void testgetTras() throws InterruptedException, ExecutionException, ModelException {
		TransactionModel tras = TransactionModel.getTras(3);
		System.out.println(tras.market);
		System.out.println(tras.apkhash);
		System.out.println(tras.developer);
		System.out.println(tras.accept);
		System.out.println(tras.appPointer);
		System.out.println(TransactionModel.isalive(0));
		for(int i=0;i<6;i++){
			System.out.println(i+": "+TransactionModel.isdeal(i));
			System.out.println(i+": "+TransactionModel.isfeedback(i));
		}
	}	
	
///	@Test
	public void testgetTrasRepPointer() throws InterruptedException, ExecutionException, ModelException{
		TransactionModel tras = TransactionModel.getTrasMarketRepPointer(2);
		Assert.assertEquals(tras.repPointer_market_pre,1);
		Assert.assertEquals(tras.repPointer_market_next,1);
	}
	
//	@Test
	public void testisalive() throws InterruptedException, ExecutionException, ModelException {
		Assert.assertTrue(TransactionModel.isalive(1));
	}
	
//	@Test
	public void testisaccept() throws InterruptedException, ExecutionException, ModelException {
		Assert.assertFalse(TransactionModel.ismalicious("1"));
	}
	
//	@Test
	public void testgetRepChange() throws InterruptedException, ExecutionException{
		Assert.assertEquals(TransactionModel.getRepChange("1"),0);		
	}
	
//	@Test
	public void testdeal() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException{

		
		TransactionModel.deal(1,Resourse.market2,false);
	}
	

	
}
