/*
 * Copyright (C) 2015 Timothy Chandler
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/

package dots.gui;

import javax.swing.JFrame;

/**@author Timothy Chandler*/
public class TestFrame extends JFrame {
    public static Game canvas;
    public TestFrame(){
        super("Test Frame");
        //canvas = new Game();
        getContentPane().add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new TestFrame();
    }
    
}
