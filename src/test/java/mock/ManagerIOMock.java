package mock;

import interfaces.IManagerIO;

public class ManagerIOMock implements IManagerIO {

	//int posicion = 0;
	//int posicionRandom = 0;

	int[] arrayInput;
	int[] arrayInputRandom;
	int posicion=0;
	int posicionRandom=0;
	


	public ManagerIOMock(int[] secuenciaInputs , int[] secuenciaRandom){
		arrayInput = new int[secuenciaInputs.length] ;
		arrayInput= secuenciaInputs;
		arrayInputRandom = new int[secuenciaRandom.length] ;
		arrayInputRandom= secuenciaRandom;
	}
	
	
	public ManagerIOMock(int[] secuenciaInputs ){

		arrayInput = new int[secuenciaInputs.length] ;
		arrayInput= secuenciaInputs;
	
	}
	
	public ManagerIOMock (){
		
	}
	
	@Override
	public int inInt() {
		
		if(posicion<arrayInput.length) {
			int aux= arrayInput[posicion];
			this.posicion++;
			return aux;
		}
		return 1;
		
				 
	}

	@Override
	public int getRandomInt() {
		
		if(posicionRandom<arrayInputRandom.length) {
			int aux= arrayInputRandom[posicionRandom];
			this.posicionRandom++;
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
