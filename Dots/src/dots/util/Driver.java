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

package dots.util;

import dots.gui.Grid;
import dots.gui.ColorSelector;
import dots.gui.DotsGUI;
import java.awt.Color;

/**@author Timothy Chandler*/
public class Driver {
    
    public static ColorSelector color;
    public static DotsGUI dots;
    public static Grid grid;
    private static Color currentColor;
    private static Color[] playerColors;
    
    public static void main(String[] args){
        color = new ColorSelector();
        dots = new DotsGUI();
        dots.setVisible(true);
        playerColors = new Color[2];
    }
    
    public static Color getCurrentColor(){
        return currentColor;
    }
    
    public static void switchColor(){
        if(currentColor.equals(playerColors[0])){
            currentColor = playerColors[1];
        }else{
            currentColor = playerColors[0];
        }
    }
    
    public static void setPlayerColors(Color p1, Color p2){
        playerColors[0] = p1;
        playerColors[1] = p2;
        currentColor = playerColors[0];
    }
}
