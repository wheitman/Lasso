import javax.sound.midi.MidiUnavailableException;

public class Main {

	public static void main(String[] args) {
		
		new LassoWindow();
		
		MidiHandler pMan = null;
		try {
			pMan = new MidiHandler("C:\\pianoman.mid");
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		pMan.playSequence();
		//pMan.printAllInstruments();
		pMan.printLoadedInstruments();
		pMan.printTransmitters();
		pMan.changeProgram(4096, 52, 0);
		pMan.changeProgram(4096, 52, 2);
		pMan.changeProgram(4096, 52, 1);

	}

}
