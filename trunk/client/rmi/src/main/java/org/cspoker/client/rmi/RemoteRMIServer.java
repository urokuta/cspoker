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
package org.cspoker.client.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.security.auth.login.LoginException;

import org.cspoker.common.CSPokerServer;
import org.cspoker.common.RemoteCSPokerServer;
import org.cspoker.common.api.shared.context.RemoteServerContext;
import org.cspoker.common.api.shared.context.ServerContext;

public class RemoteRMIServer implements RemoteCSPokerServer {

	private CSPokerServer server;

	public RemoteRMIServer(String server) throws RemoteException, NotBoundException {
		this(server, 1099);
	}

	public RemoteRMIServer(String server, int port)
			throws RemoteException, NotBoundException {
		System.setSecurityManager(null);
		Registry registry = LocateRegistry.getRegistry(server, port);
		this.server = (CSPokerServer) registry.lookup("CSPokerServer");
	}

	public RemoteServerContext login(String username, String password)
			throws RemoteException, LoginException {

		ServerContext context = server.login(username, password);
		return new ServerContextStub(context);
	}

}