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
package org.cspoker.common.jaxbcontext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.cspoker.common.api.account.action.ChangePasswordAction;
import org.cspoker.common.api.account.action.CreateAccountAction;
import org.cspoker.common.api.account.action.GetAvatarAction;
import org.cspoker.common.api.account.action.SetAvatarAction;
import org.cspoker.common.api.cashier.action.MoneyAmountAction;
import org.cspoker.common.api.cashier.action.RequestMoneyAction;
import org.cspoker.common.api.chat.action.SendServerMessageAction;
import org.cspoker.common.api.chat.action.SendTableMessageAction;
import org.cspoker.common.api.lobby.action.CreateTableAction;
import org.cspoker.common.api.lobby.action.JoinTableAction;
import org.cspoker.common.api.lobby.action.TableInformationAction;
import org.cspoker.common.api.lobby.action.TableListAction;
import org.cspoker.common.api.lobby.holdemtable.action.LeaveTableAction;
import org.cspoker.common.api.lobby.holdemtable.action.SitInAction;
import org.cspoker.common.api.lobby.holdemtable.action.StartGameAction;
import org.cspoker.common.api.lobby.holdemtable.holdemplayer.action.BetOrRaiseAction;
import org.cspoker.common.api.lobby.holdemtable.holdemplayer.action.CheckOrCallAction;
import org.cspoker.common.api.lobby.holdemtable.holdemplayer.action.FoldAction;
import org.cspoker.common.api.lobby.holdemtable.holdemplayer.action.LeaveGameAction;

public class ActionJAXBContext {

	private final static Logger logger = Logger
			.getLogger(ActionJAXBContext.class);

	public final static JAXBContext context = initContext();

	private static JAXBContext initContext() {
		try {
			return JAXBContext.newInstance(getActions());
		} catch (JAXBException e) {
			logger.fatal(e);
			throw new IllegalStateException(e);
		}
	}

	public static Class<?>[] getActions() {
		return new Class<?>[] { BetOrRaiseAction.class,
				CheckOrCallAction.class, CreateTableAction.class,
				FoldAction.class, JoinTableAction.class,
				LeaveTableAction.class, SendServerMessageAction.class,
				StartGameAction.class, TableInformationAction.class,
				TableListAction.class, MoneyAmountAction.class, RequestMoneyAction.class, 
				SendTableMessageAction.class, SitInAction.class, LeaveGameAction.class,
				ChangePasswordAction.class, CreateAccountAction.class, GetAvatarAction.class,
				SetAvatarAction.class};
	}

}
