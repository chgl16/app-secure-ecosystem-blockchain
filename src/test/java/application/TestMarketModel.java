package application;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Test;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.exceptions.TransactionTimeoutException;

public class TestMarketModel {

	@Test
	public void testMarketRegister_login() throws InterruptedException, ExecutionException, ModelException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, IOException, CipherException {
	//	File path = Resourse.Path;
		MarketModel.MarketRegister(Resourse.owner,"owner","owner");
	//	MarketModel market = MarketModel.login(Resourse.owner);
	//	Assert.assertEquals(market.addr,Resourse.owner.getAddress());
	}
	
//	@Test
	public void testgetMarketRepPointer() throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException {
		Assert.assertEquals(MarketModel.getMarketRepPointer(1),0);
	}
	
//	@Test
	public void testnumMarkets() throws InterruptedException, ExecutionException {
		Assert.assertEquals(MarketModel.numMarkets(),6);
	}

//	@Test	
	public void testMarketModifyDesc() throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException {
		MarketModel market = MarketModel.login(Resourse.market2);
		System.out.println(market.name+"\n"+market.desc);
		market.marketModifyDesc("market2");
		market = MarketModel.login(Resourse.market2);
		Assert.assertEquals(market.desc,"asd");
	}
	
//	@Test
	public void testMarketModifyName() throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException {
		MarketModel market = MarketModel.login(Resourse.market2);
		System.out.println(market.credentials.getAddress());
		System.out.println(market.credentials.getEcKeyPair().getPrivateKey());
		System.out.println(market.credentials.getEcKeyPair().getPublicKey());
		System.out.println(market.name);
		System.out.println(market.desc);
		System.out.println(market.registerTime);
		System.out.println(market.repPointer);
		System.out.println(market.reputation);
		market.marketModifyName("market2");
		market = MarketModel.login(Resourse.market2);
		Assert.assertEquals(market.name,"asd");
	}

//	@Test
	public void testfeedback() throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException {
		MarketModel market = MarketModel.login(Resourse.owner);
//		MarketModel.feedback(market.marketID,6);
		market = MarketModel.login(Resourse.owner);
		Assert.assertEquals(market.reputation,94);
	}
	
//	@Test
	public void testupdateRepPointer() throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException {
		MarketModel market = MarketModel.login(Resourse.market2);
	//	market.updateRepPointer(2,0);
		market = MarketModel.login(Resourse.market2);
		Assert.assertEquals(market.repPointer,0);
	}
}
