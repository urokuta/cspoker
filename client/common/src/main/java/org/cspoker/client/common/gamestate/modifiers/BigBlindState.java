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
package org.cspoker.client.common.gamestate.modifiers;

import org.cspoker.client.common.gamestate.ForwardingGameState;
import org.cspoker.client.common.gamestate.ForwardingPlayerState;
import org.cspoker.client.common.gamestate.GameState;
import org.cspoker.client.common.gamestate.PlayerState;
import org.cspoker.common.api.lobby.holdemtable.event.BigBlindEvent;
import org.cspoker.common.api.lobby.holdemtable.event.HoldemTableEvent;
import org.cspoker.common.elements.player.PlayerId;

public class BigBlindState extends ForwardingGameState {

	private final BigBlindEvent event;
	private final int newPot;
	private final PlayerState playerState;

	public BigBlindState(GameState gameState, BigBlindEvent event) {
		super(gameState);
		this.event = event;
		PlayerState oldPlayerState = super.getPlayer(event.getPlayerId());
		final int newStack = oldPlayerState.getStack()-event.getAmount();
		this.newPot = super.getRoundPotSize()+event.getAmount();
		playerState = new ForwardingPlayerState(oldPlayerState){
			@Override
			public int getBet() {
				return BigBlindState.this.event.getAmount();
			}
			
			@Override
			public int getStack() {
				return newStack;
			}
			
			@Override
			public boolean sitsIn() {
				return true;
			}
			
			@Override
			public boolean hasFolded() {
				return false;
			}
			
			@Override
			public PlayerId getPlayerId() {
				return BigBlindState.this.event.getPlayerId();
			}
		};
	}
	
	@Override
	public PlayerState getPlayer(PlayerId playerId) {
		if(event.getPlayerId().equals(playerId)){
			return playerState;
		}
		return super.getPlayer(playerId);
	}

	@Override
	public int getLargestBet() {
		return event.getAmount();
	}

	@Override
	public int getMinNextRaise() {
		return event.getAmount();
	}

	@Override
	public int getRoundPotSize() {
		return newPot;
	}
	
	public HoldemTableEvent getLastEvent() {
		return event;
	}
	
	@Override
	public PlayerId getLastBettor() {
		return event.getPlayerId();
	}

}