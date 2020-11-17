package net.seeruk.fabricdisposal;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerFactory;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

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
public class ModInitializer implements net.fabricmc.api.ModInitializer {
    @Override
    public void onInitialize() {
        System.out.println("Disposal initialised");

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager.literal("disposal").executes(context -> {
                ServerCommandSource source = context.getSource();

                if (source.getPlayer() != null) {
                    ServerPlayerEntity player = source.getPlayer();

                    source.sendFeedback(new LiteralText("Opening disposal..."), false);
                    player.openHandledScreen(new DisposalScreenHandlerFactory());
                }

                return 1;
            }));
        });
    }
}

class DisposalScreenHandlerFactory implements ScreenHandlerFactory, NamedScreenHandlerFactory {
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return GenericContainerScreenHandler.createGeneric9x3(syncId, player.inventory, new SimpleInventory(27));
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Disposal");
    }
}
