package blockchain;

import java.util.*;

public class BlockChain {
	Stack<Block> blocks;

	BlockChain() {
		blocks = new Stack<Block>();
	}

	void addNew(String data) {
		Data d = new Data(data);
		Block b = null;

		if(!blocks.empty()) {
			b = blocks.peek();
		}

		Block n = new Block(b,d);

		blocks.add(n);
	}

	boolean isValid() {
		Stack<Block> verify = blocks;

		Block atual = verify.pop();

		while(!verify.empty()) {

			String h = atual.hashBlock(verify.peek());
			if(h != atual.lastHash) return false;

			atual = verify.pop();
		}

		return true;
	}

	int chainSize() {
		return blocks.size();
	}
}