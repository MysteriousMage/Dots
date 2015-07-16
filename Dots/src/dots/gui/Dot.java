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

import java.awt.geom.Ellipse2D;

/**@author Timothy Chandler*/
public class Dot {
    
    private Ellipse2D ellipse;
    private int[] location;
    
    public Dot(int row, int column, Ellipse2D e){
        ellipse = e;
        location = new int[2];
        location[0] = row;
        location[1] = column;
    }

    /**
     * @return the ellipse
     */
    public Ellipse2D getEllipse() {
        return ellipse;
    }

    /**
     * @param ellipse the ellipse to set
     */
    public void setEllipse(Ellipse2D ellipse) {
        this.ellipse = ellipse;
    }

    /**
     * @return the location
     */
    public int[] getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(int[] location) {
        this.location = location;
    }
    
}
