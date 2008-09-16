/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.common.api.lobby.holdemtable.event;

import javax.xml.bind.annotation.XmlRootElement;

import org.cspoker.common.elements.player.ShowdownPlayer;

/**
 * A class to represent show hand events.
 * 
 * @author Kenzo
 * 
 */
@XmlRootElement
public class ShowHandEvent implements HoldemTableEvent {

	private static final long serialVersionUID = -3412700183566852150L;

	private ShowdownPlayer player;

	public ShowHandEvent(ShowdownPlayer player) {
		this.player = player;
	}

	protected ShowHandEvent() {
		// no op
	}

	public String toString() {
		return player.toString();
	}

	public ShowdownPlayer getShowdownPlayer() {
		return player;
	}
	
	public void dispatch(HoldemTableListener holdemTableListener) {
		holdemTableListener.onShowHand(this);
	}

}
