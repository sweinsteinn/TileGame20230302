package game.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    public static KeyManager keyManager = null;

    private final boolean[] keys;
    private boolean[] justPressed;
    private boolean[] cantPress;

    private KeyManager() {
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }

    public static KeyManager getKeyManager() {
        if(keyManager == null)
            keyManager = new KeyManager();
        return keyManager;
    }

    public void tick() {
        for(int i = 0; i < keys.length; i++) {
            if(cantPress[i] && !keys[i]) {
                cantPress[i] = false;
            }
            else if(justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if(!cantPress[i] && keys[i]) {
                justPressed[i] = true;
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = false;
    }

    public boolean keyJustPressed(int keyCode) {
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }

}
