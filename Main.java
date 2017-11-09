package blockchain;

class Main {
	public static void main(String[] args) {
		BlockChain b = new BlockChain();

		assert(b.isValid());
		assert(b.chainSize() == 0);

		b.addNew("stringdeteste");
		assert(b.isValid());
		assert(b.chainSize() == 1);
		
		b.addNew("outroteste");
		assert(b.chainSize() == 2);
		assert(b.isValid());
	} 
}