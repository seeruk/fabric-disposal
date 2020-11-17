package net.seeruk.fabricdisposal;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

/**
 * This file is part of the "fabric-disposal" project.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the LICENSE is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * <p>
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
public class ClientModInitializer implements net.fabricmc.api.ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Disposal initialised");
    }
}
