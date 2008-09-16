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
package org.cspoker.common.api.lobby.holdemtable.holdemplayer.event;

import java.util.Collections;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.cspoker.common.api.lobby.holdemtable.event.HoldemTableEvent;
import org.cspoker.common.api.lobby.holdemtable.event.HoldemTableListener;
import org.cspoker.common.elements.cards.Card;

@XmlRootElement
public class NewPocketCardsEvent implements HoldemTableEvent {

	private static final long serialVersionUID = -3328895783353781276L;

	@XmlElementWrapper
	@XmlElement(name = "card")
	private Set<Card> pocketCards;

	public NewPocketCardsEvent(Set<Card> pocketCards) {
		this.pocketCards = Collections.unmodifiableSet(pocketCards);
	}

	protected NewPocketCardsEvent() {
		// no op
	}

	public Set<Card> getPocketCards() {
		return pocketCards;
	}

	public String toString() {
		String toReturn = "You have received new pocket cards: ";
		for (Card card : getPocketCards()) {
			toReturn += card;
			toReturn += ", ";
		}
		return toReturn.substring(0, toReturn.length() - 2) + ".";
	}
	
	public void dispatch(HoldemTableListener holdemTableListener) {
		holdemTableListener.onNewPocketCards(this);
	}
	
}