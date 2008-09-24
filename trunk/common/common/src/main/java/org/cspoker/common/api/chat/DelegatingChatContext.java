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
package org.cspoker.common.api.chat;

import org.cspoker.common.api.chat.event.RemoteChatListener;

public class DelegatingChatContext implements ChatContext{

	private final ChatContext chatContext;

	public DelegatingChatContext(ChatContext chatContext) {
		this.chatContext  = chatContext;
	}

	public void sendServerMessage(String message) {
		chatContext.sendServerMessage(message);
	}

	public void sendTableMessage(long tableId, String message) {
		chatContext.sendTableMessage(tableId, message);
	}

	public void subscribe(RemoteChatListener chatListener) {
		chatContext.subscribe(chatListener);
	}

	public void unSubscribe(RemoteChatListener chatListener) {
		chatContext.unSubscribe(chatListener);
	}
	
}
