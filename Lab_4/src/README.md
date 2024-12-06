# Ecosystem Simulation

This project simulates a simple ecosystem with various entities interacting over time.
# Ecosystem Simulation

This project simulates a simple ecosystem with various entities interacting over time.


## Classes

### EcosystemEntity
- Base class for all entities in the ecosystem.
- Attributes: name, energy, x, y coordinates.

### Plant
- Extends EcosystemEntity.
- Represents stationary food sources.

### Animal
- Extends EcosystemEntity.
- Base class for mobile entities.
- Implements movement and energy consumption.

### Herbivore
- Extends Animal.
- Consumes plants for energy.
- Can reproduce when energy is sufficient.

### Carnivore
- Extends Animal.
- Hunts herbivores for energy.
- Can reproduce when energy is sufficient.

### Omnivore
- Extends Animal.
- Can hunt herbivores and eat plants.
- Can reproduce when energy is sufficient.

### Ecosystem
- Manages all entities and simulates their interactions.
- Methods for adding entities, simulating steps, and displaying state.

## Main Simulation

The `Main` class sets up the initial ecosystem state and runs the simulation:
- Creates an ecosystem with plants, herbivores, carnivores, and omnivores.
- Simulates 5 steps of ecosystem interaction.
- Displays the ecosystem state after each step.

## Usage

Run the `Main` class to start the simulation. The console will display the ecosystem state and interactions for each step.

## Future Improvements

- Add more complex interactions between entities.
- Implement a graphical interface for better visualization.
- Include environmental factors affecting the ecosystem.