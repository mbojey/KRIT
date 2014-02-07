package gui;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

  public class MyDispatcher implements KeyEventDispatcher
    {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e)
        {
            if (e.getKeyCode() == 38) //up key
            {
            //Do something when the up key is pressed
            System.out.println("The up key was pressed");
            }
            else if (e.getKeyCode() == 40) //down key
            {
                //Do something when the down key is pressed
                System.out.println("The down key was pressed");
            }
            return false;
        }
    }