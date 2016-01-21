package com.tino1b2be.cmdprograms;

import com.tino1b2be.DTMFDecoder.DTMFDecoderException;
import com.tino1b2be.DTMFDecoder.DTMFUtil;
import com.tino1b2be.DTMFDecoder.DecoderUtil;
import com.tino1b2be.DTMFDecoder.FileUtil;
import com.tino1b2be.audio.AudioFile;
import com.tino1b2be.audio.AudioFileException;

public class TestDTMFDecoder {
	private static String filename;

	public static void main(String[] args) throws AudioFileException, Exception {
		
		if (args.length == 2){
			filename = args[0];
			DTMFUtil.setMinToneDuration(Integer.parseInt(args[1]));
		} else {
			getInputFromUser();
		}
		double start = System.currentTimeMillis();
		
		DTMFUtil.setMinToneDuration(60);
		DTMFUtil.debug = true;
////		DTMFUtil.db = false;

////		filename = "samples/mag3.wav";
////		filename = "/home/tino1b2be/workspace/DTMF-Decoder/Prototyping/Noisy Test Data/10dB/9909257037*6A8897*3598B088#6#*B#49B8.wav";
//		filename = "samples/whiteNoise.wav";
//		filename = "samples/callx.wav";
//		filename = "/home/tino1b2be/workspace/DTMF-Decoder/Prototyping/Test Data/-27dBm to -10dBm/C2AC81059AA13.wav";
		

		AudioFile data = FileUtil.readAudioFile(filename);
//		data.display();
		
		
		DTMFUtil dtmf = new DTMFUtil(data);	
		String original = DecoderUtil.getFileSequence(filename);
		String[] sequence = dtmf.decode();
				
		System.out.println("\noriginal1 = " + original
				+ "\ndecoded1  = " + sequence[0]);
		System.out.println("\noriginal2 = " + original
				+ "\ndecoded1  = " + sequence[1]);		
				
		double stop = System.currentTimeMillis();
		System.out.println("Time taken = " + Double.toString((stop-start)/1000) + "sec.");
		
	}

	private static void getInputFromUser() {
		// TODO Auto-generated method stub
		
	}
}
