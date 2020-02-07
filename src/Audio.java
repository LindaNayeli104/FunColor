//Linda Nayeli Abundis Lopez A01636416
//Oscar Fernandez Moreno 	 A07013362

import java.applet.AudioClip;

public class Audio {
	public AudioClip getAudio(String direccion) {
		return java.applet.Applet.newAudioClip(getClass().getResource(direccion));
	}
}
