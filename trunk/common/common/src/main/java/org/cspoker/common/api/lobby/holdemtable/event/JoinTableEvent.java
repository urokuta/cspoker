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

import org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener;
import org.cspoker.common.elements.player.Player;

public class JoinTableEvent extends HoldemTableEvent {
	
	private static final long serialVersionUID = -803418266888400234L;
	
	private Player player;
	
	public JoinTableEvent(Player player) {
		this.player = player;
	}

	protected JoinTableEvent() {
		// no op
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public String toString() {
		return player.getName() + " has joined this table.";
	}
	
	@Override
	public void dispatch(HoldemTableListener holdemTableListener) {
		// TODO Auto-generated method stub

	}

}