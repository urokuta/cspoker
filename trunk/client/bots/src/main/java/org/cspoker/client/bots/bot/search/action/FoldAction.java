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
package org.cspoker.client.bots.bot.search.action;

import java.rmi.RemoteException;

import org.cspoker.client.bots.bot.search.opponentmodel.OpponentModel;
import org.cspoker.client.common.gamestate.GameState;
import org.cspoker.client.common.gamestate.modifiers.FoldState;
import org.cspoker.common.api.lobby.holdemtable.event.FoldEvent;
import org.cspoker.common.api.lobby.holdemtable.holdemplayer.context.RemoteHoldemPlayerContext;
import org.cspoker.common.api.shared.exception.IllegalActionException;
import org.cspoker.common.elements.player.PlayerId;

public class FoldAction extends SimulatedBotAction{

	public FoldAction() {
	}
	
	@Override
	public void perform(RemoteHoldemPlayerContext context) throws RemoteException, IllegalActionException {
		context.fold();
	}
	
	@Override
	public GameState getNextState(GameState gameState, PlayerId actor) {
		return new FoldState(gameState, new FoldEvent(actor));
	}
	
	@Override
	public boolean hasSubTree() {
		return false;
	}

	@Override
	public String toString() {
		return "Folding";
	}


	public double calculateProbabilityIn(OpponentModel opponentModel,
			GameState gameState) {
		return opponentModel.getFoldProbability(gameState);
	}
	
}