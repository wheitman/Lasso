

import java.io.File;
import java.io.IOException;

import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;

public class MidiHandler {

	public Synthesizer synth;
	public Sequencer seq;
	
	public MidiHandler() throws MidiUnavailableException{
		
		synth = MidiSystem.getSynthesizer();
		
		seq = MidiSystem.getSequencer(false);
		
		seq.open();
		synth.open();
		//connect synth to sequencer
		seq.getTransmitter().setReceiver(synth.getReceiver());
		
		
	}
	
	public MidiHandler(String fileName) throws MidiUnavailableException{
		
		File midiFile = new File(fileName);

		synth = MidiSystem.getSynthesizer();

		seq = MidiSystem.getSequencer(false);

		seq.getTransmitter().setReceiver(synth.getReceiver());
		seq.open();
		synth.open();
		try {
			Sequence midiSequence = MidiSystem.getSequence(midiFile);
			seq.setSequence(midiSequence);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void playSequence(){
		
		seq.start();
		
	}	
	
	public void printAllInstruments(){
		Soundbank soundbank = synth.getDefaultSoundbank();
        Instrument[] instr = soundbank.getInstruments();
        for(int i = 0; i<instr.length; i++){
        	System.out.println(String.valueOf(i) +": "+ instr[i]);
        }
	}
	
	public void printLoadedInstruments(){

		Instrument[] instruments = synth.getLoadedInstruments();
		
		int i = 1;
		for(Instrument instrument : instruments)
			System.out.println(instrument.getPatch().getBank()+" : "+instrument.getPatch().getProgram()+" : "+instrument.getName());
		
	}
	
	public void printTransmitters(){
		
		System.out.println(seq.getTransmitters());
		
	}
	
	public Instrument[] getLoadedInstruments(){
		
		return synth.getLoadedInstruments();
		
	}
	
	public void changeProgram(int bank, int program, int channelNumber){
		
		MidiChannel channel = synth.getChannels()[channelNumber];
		channel.programChange(bank, program);
		
	}
	
}
