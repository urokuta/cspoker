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
package org.cspoker.server.game.playerCommunication;

import org.cspoker.server.game.GameManager;
import org.cspoker.server.game.elements.table.Table;
import org.cspoker.server.game.events.serverEvents.PlayerLeftEvent;
import org.cspoker.server.game.gameControl.IllegalActionException;


/**
 * A class to represent the state where the player is waiting
 * for the game to start.
 *
 * WaitingAtTableState  --------------------------------> 	InitialState
 *        \            		leaveTable()
 *         \
 *          \
 *           ------------------------------------------->	PlayingState
 *           				The owner of the table
 *           				calls startGame()
 * @author Kenzo
 *
 */
class WaitingAtTableState extends PlayerCommunicationState {

	protected final Table table;

	public WaitingAtTableState(PlayerCommunicationImpl playerCommunication, Table table) {
		super(playerCommunication);
		this.table = table;
	}

	@Override
	public void leaveTable() throws IllegalActionException{
		table.removePlayer(playerCommunication.getPlayer());
		playerCommunication.setPlayerCommunicationState(new InitialState(playerCommunication));
		GameManager.getServerMediator().publishPlayerLeftEvent(new PlayerLeftEvent(playerCommunication.getPlayer().getSavedPlayer(), table.getId()));
	}

	@Override
	protected String getStdErrorMessage() {
		return "You are waiting at a table for a game to begin.";
	}

}