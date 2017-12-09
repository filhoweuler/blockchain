package blockchain;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;

public class Main {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		BlockChain b = new BlockChain();

		assert(b.isValid());
		assert(b.chainSize() == 0);

		String msg1 = "stringdeteste";
		String msg2 = "outroteste";

		RemetenteAssiDig remetente = new RemetenteAssiDig();
		DestinatarioAssiDig destinatario = new DestinatarioAssiDig(); 

		b.addNew(msg1);

		byte[] assinatura = remetente.geraAssinatura(msg1); //assina a transacao no bloco
		PublicKey pubKey = remetente.getPubKey(); //pub key para verificacao
		destinatario.recebeMensagem(pubKey, msg1, assinatura); //dado correto

		String msgFalsa = "string falsa!";
		destinatario.recebeMensagem(pubKey, msgFalsa, assinatura); //dado incorreto, problema

		assert(b.isValid());
		assert(b.chainSize() == 1);
		
		b.addNew(msg2);
		assert(b.chainSize() == 2);
		assert(b.isValid());
	} 
}