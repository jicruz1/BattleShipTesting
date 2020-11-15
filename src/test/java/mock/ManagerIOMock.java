package mock;

import interfaces.IManagerIO;

public class ManagerIOMock implements IManagerIO {



	int[] arrayInput;
	int[] arrayInputRandom;
	int position=0;
	int positionRandom=0;
	


	public ManagerIOMock(int[] inputsSequence , int[] randomSequence){
		arrayInput = new int[inputsSequence.length] ;
		arrayInput= inputsSequence;
		arrayInputRandom = new int[randomSequence.length] ;
		arrayInputRandom= randomSequence;
	}
	
	
	public ManagerIOMock(int[] inputsSequence ){

		arrayInput = new int[inputsSequence.length] ;
		arrayInput= inputsSequence;
	
	}
	
	public ManagerIOMock (){
		
	}
	
	@Override
	public int inInt() {
		
		if(position<arrayInput.length) {
			int aux= arrayInput[position];
			this.position++;
			return aux;
		}
		return 1;
		
				 
	}

	@Override
	public int getRandomInt() {
		
		if(positionRandom<arrayInputRandom.length) {
			int aux= arrayInputRandom[positionRandom];
			this.positionRandom++;
			return aux;
		}
		return 1;
		
	}



	@Override
	public void out(String data) {
		// Do nothing
	}

	@Override
	public void out(int data) {
		// Do nothing
	}

}
