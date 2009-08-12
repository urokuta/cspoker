/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.client.bots.experiments;

import java.io.IOException;

import org.cspoker.client.bots.BotRunner;
import org.cspoker.client.bots.bot.BotFactory;
import org.cspoker.client.bots.bot.gametree.mcts.FixedSampleMCTSBotFactory;
import org.cspoker.client.bots.bot.gametree.mcts.MCTSBotFactory;
import org.cspoker.client.bots.bot.gametree.mcts.nodes.MCTSBucketShowdownNode;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.backpropagation.MaxDistributionBackPropStrategy;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.backpropagation.MixedBackPropStrategy;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.backpropagation.SampleWeightedBackPropStrategy;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.selection.MaxValueSelector;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.selection.SamplingSelector;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.selection.SamplingToFunctionSelector;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.selection.UCTSelector;
import org.cspoker.client.bots.bot.gametree.opponentmodel.weka.WekaRegressionModelFactory;
import org.cspoker.client.communication.embedded.EmbeddedCSPokerServer;

@Deprecated
public class RunExperimentB {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		if(args[0].equals("time")){

			int time = Integer.parseInt(args[1]);
			
			int C = Integer.parseInt(args[2]);
			int treshold1 = Integer.parseInt(args[3]);
			
			int treshold2 = Integer.parseInt(args[4]);

			new BotRunner(
					new EmbeddedCSPokerServer(),
					new BotFactory[] {
						new MCTSBotFactory(
								"Standard Bot",
								WekaRegressionModelFactory.createForZip("org/cspoker/client/bots/bot/search/opponentmodel/weka/models/model1.zip"),
								new SamplingToFunctionSelector(treshold1,new UCTSelector(C)),
								new SamplingSelector(),
								new MaxValueSelector(),
								new MCTSBucketShowdownNode.Factory(),
								new SampleWeightedBackPropStrategy.Factory(),
								time
						),
						new MCTSBotFactory(
								"MaxDistribution Bot",
								WekaRegressionModelFactory.createForZip("org/cspoker/client/bots/bot/search/opponentmodel/weka/models/model1.zip"),
								new SamplingToFunctionSelector(treshold1,new UCTSelector(C)),
								new SamplingSelector(),
								new MaxValueSelector(),
								new MCTSBucketShowdownNode.Factory(),
								new MixedBackPropStrategy.Factory(
										treshold2,
										new SampleWeightedBackPropStrategy.Factory(),
										new MaxDistributionBackPropStrategy.Factory()
								),
								time
						)
					}
			);
		}else if(args[0].equals("samples")){

			int p = Integer.parseInt(args[1]);
			int f = Integer.parseInt(args[2]);
			int t = Integer.parseInt(args[3]);
			int r = Integer.parseInt(args[4]);
			
			int C = Integer.parseInt(args[5]);
			int treshold1 = Integer.parseInt(args[6]);

			int treshold2 = Integer.parseInt(args[7]);


			new BotRunner(
					new EmbeddedCSPokerServer(),
					new BotFactory[] {
						new FixedSampleMCTSBotFactory(
								"Standard Bot",
								WekaRegressionModelFactory.createForZip("org/cspoker/client/bots/bot/search/opponentmodel/weka/models/model1.zip"),
								new SamplingToFunctionSelector(treshold1,new UCTSelector(C)),
								new SamplingSelector(),
								new MaxValueSelector(),
								new MCTSBucketShowdownNode.Factory(),
								new SampleWeightedBackPropStrategy.Factory(),
								p,f,t,r
						),
						new FixedSampleMCTSBotFactory(
								"MaxDistribution Bot",
								WekaRegressionModelFactory.createForZip("org/cspoker/client/bots/bot/search/opponentmodel/weka/models/model1.zip"),
								new SamplingToFunctionSelector(treshold1,new UCTSelector(C)),
								new SamplingSelector(),
								new MaxValueSelector(),
								new MCTSBucketShowdownNode.Factory(),
								new MixedBackPropStrategy.Factory(
										treshold2,
										new SampleWeightedBackPropStrategy.Factory(),
										new MaxDistributionBackPropStrategy.Factory()
								),
								p,f,t,r
						)
					}
			);

		}

	}

}