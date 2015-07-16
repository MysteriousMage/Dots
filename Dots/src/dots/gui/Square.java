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

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**@author Timothy Chandler*/
public class Square {
    
    private ArrayList<Connection> connectors;
    private ArrayList<Dot> dots;
    private Rectangle2D rectangle;
    private Color color;
    
    public Square(ArrayList<Connection> c, ArrayList<Dot> d, Rectangle2D r){
        connectors = new ArrayList<>();
        for(Connection a:c){
            connectors.add(a);
        }
        dots = new ArrayList<>();
        for(Dot a:d){
            dots.add(a);
        }
        rectangle = r;
        color = null;
    }
    
    public boolean isDrawn(){
        for(Connection c: connectors) {
            if(!c.isUsed()){
                return false;
            }
        }
        return true;
    }

    /**
     * @return the connectors
     */
    public ArrayList<Connection> getConnectors() {
        return connectors;
    }

    /**
     * @param connectors the connectors to set
     */
    public void setConnectors(ArrayList<Connection> connectors) {
        this.connectors = connectors;
    }

    /**
     * @return the rectangle
     */
    public Rectangle2D getRectangle() {
        return rectangle;
    }

    /**
     * @param rectangle the rectangle to set
     */
    public void setRectangle(Rectangle2D rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * @return the dots
     */
    public ArrayList<Dot> getDots() {
        return dots;
    }

    /**
     * @param dots the dots to set
     */
    public void setDots(ArrayList<Dot> dots) {
        this.dots = dots;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
}
