

package evoting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class VotingServer {
	int maxSize = 4;

	BufferedReader br;
	private int voterID;
	private int[] officialTally = new int[8];
	String[][] voterInfo = new String [1][4];

	protected void getTally() {
		throw new UnsupportedOperationException();
	}

	protected void getNumRegisteredVoters() {
		throw new UnsupportedOperationException();
	}

	protected void getNumTotatlVotes() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userName
	 * @param Password
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public boolean validateLogin(int voterID, String lastName, int last4social) throws FileNotFoundException, IOException {
		try{
		br = new BufferedReader(new FileReader("registrationList.txt")); 
		    //StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    System.out.println(line);
		    
		
		    StringTokenizer st = new StringTokenizer(line);
		    int i =0;
		    while(st.hasMoreTokens()){
		    	voterInfo[0][i] = st.nextToken(); 
		    	System.out.println(st.nextToken());
		    	i++;
		    	
		    }
		    
		    
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	

	/**
	 * 
	 * @param voterUserName
	 * @param VoterPassword
	 */
	private void checkIfRegistered(String voterUserName, String VoterPassword) {
		throw new UnsupportedOperationException();
	}

	protected void displayCandidate() {
		throw new UnsupportedOperationException();
	}

	protected void displayLoginErrorMessage() {
		throw new UnsupportedOperationException();
	}

	protected void displayVoterToVotesRatio() {
		throw new UnsupportedOperationException();
	}

	private void displayUnofficialTally() {
		throw new UnsupportedOperationException();
	}

	private void addVoteToTally() {
		throw new UnsupportedOperationException();
	}

	protected void updateResult() {
		throw new UnsupportedOperationException();
	}

	private void printConfirmation() {
		throw new UnsupportedOperationException();
	}

}