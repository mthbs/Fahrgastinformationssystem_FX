package de.fis.addon.audio;

import marytts.LocalMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

import java.util.Locale;


public class AnsagenCreator {


    public void spieleText(String text) throws MaryConfigurationException, SynthesisException {
        LocalMaryInterface marytts = new LocalMaryInterface();
        marytts.setVoice("bits1-hsmm");
        marytts.setLocale(Locale.GERMAN);
        AudioPlayer player = new AudioPlayer();
        text = text.replace("RE", "RE ").replace("RB", "RB ").replace("ICE", "ICE ").replace("FLX", "FLX ");
        text = text.replace("Hbf", "Hauptbahnhof").replace("(Main)", "").replace("(Taunus)", "").replace("(Odenwald)","");
        text = text.replace("F-", "Frankfurt ");
        player.setAudio(marytts.generateAudio(text));
        player.start();
    }

}
