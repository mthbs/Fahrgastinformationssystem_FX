package de.fis.addon.audio;


import marytts.LocalMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

import java.util.Locale;


public class AudioTest {

    public static void main(String[] args) throws MaryConfigurationException, SynthesisException {
        LocalMaryInterface marytts = new LocalMaryInterface();
        System.out.println("Available voices: " + marytts.getAvailableVoices());
        marytts.setVoice("bits1-hsmm");
        marytts.setLocale(Locale.GERMAN);
        AudioPlayer player = new AudioPlayer();
        String text = "RE 50 nach Frankfurt (Main) Hbf um 12 Uhr 33";
        text = text.replace("Hbf", "Hauptbahnhof").replace("(Main)", "am Main");
        StringBuilder kompletteAnsage = new StringBuilder("Ihre Nächsten Anschlüsse: \t");
        kompletteAnsage.append(text);
        player.setAudio(marytts.generateAudio(kompletteAnsage.toString()));
        player.start();
    }

}
