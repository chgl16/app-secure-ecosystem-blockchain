package application;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Test;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.exceptions.TransactionTimeoutException;

public class TestUserModel {

	@Test
	public void testnumUsers() throws InterruptedException, ExecutionException {
		Assert.assertEquals(UserModel.numUsers(),1);
	}
	
//	@Test
	public void testRegistwithCred() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException, InterruptedException, ExecutionException, ModelException{
	//	String filename = WalletUtils.generateFullNewWalletFile("1234",Resourse.Path);
	//	Credentials cred = WalletUtils.loadCredentials("123456", "E:\\geth\\chain1\\keystore\\"
				//	+filename);
	//				+"UTC--2017-05-15T14-37-11.949000000Z--5d2b0e7765012df8cbae89bfa247ab356633e20a.json");
		UserModel.UserRegister(Resourse.owner,"123","123","123");
		
	//	System.out.println(cred.getAddress());
	//	System.out.println(cred.getEcKeyPair().getPrivateKey());
	//	System.out.println(cred.getEcKeyPair().getPublicKey());

	}

	@Test
	public void testquota() throws InterruptedException, ExecutionException, IOException, CipherException {
		Assert.assertEquals(UserModel.quota(),100000);
	}
	
	@Test
	public void testRegister_login() throws InterruptedException, ExecutionException, ModelException, IOException, CipherException, TransactionTimeoutException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
		//Credentials cred = UserModel.Register("123456","user","user","user");
		Credentials cred = WalletUtils.loadCredentials("123456", "E:\\geth\\chain1\\keystore\\"
			//+filename);
				+"UTC--2017-05-25T08-34-57.808000000Z--c599ed1d01535d2f8d0de01ebcd9ef490366400c.json");
		UserModel.UserRegister(cred,"developer","market6","market6");
		System.out.println(cred.getAddress());
		System.out.println(cred.getEcKeyPair().getPrivateKey());
		System.out.println(cred.getEcKeyPair().getPublicKey());
		
	/*	Thread.sleep(10000);
		UserModel user = UserModel.login(cred);
		Assert.assertEquals(user.credentials,Resourse.owner);
		Assert.assertEquals(user.name,"user");
		Assert.assertEquals(user.reputation,100);
		Assert.assertEquals(user.desc,"user");
		Assert.assertEquals(user.userType,"user");*/
	}				
	
//	@Test
	public void testgetUserRepPointer() throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException {
		Assert.assertEquals(UserModel.getUserRepPointer("0xd670Eab0dB56d1e6f43c8bd48ccaDED0DADb14A4"),10);
	}	

//	@Test
	public void testUserModifyDesc() throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException {
		UserModel user = UserModel.login(Resourse.owner);
		user.userModifyDesc("asd");
		user = UserModel.login(Resourse.owner);
		Assert.assertEquals(user.desc,"asd");
	}
	
//	@Test
	public void testUserModifyName() throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException {
		UserModel user = UserModel.login(Resourse.owner);
		user.userModifyName("asd");
		user = UserModel.login(Resourse.owner);
		Assert.assertEquals(user.name,"asd");
	}
	
//	@Test
	public void testfeedback() throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException {
		UserModel user = UserModel.login(Resourse.owner);
//		UserModel.feedback(Resourse.owner.getAddress(),6);
		user = UserModel.login(Resourse.owner);
		Assert.assertEquals(user.reputation,94);
	}
	
//	@Test
	public void testupdateRepPointer() throws InterruptedException, ExecutionException, IOException, CipherException, TransactionTimeoutException, ModelException {
	//	UserModel.updateRepPointer(Resourse.owner.getAddress(),10);
		UserModel user = UserModel.login(Resourse.owner);
		Assert.assertEquals(user.repPointer,10);
	}
	
	
}
