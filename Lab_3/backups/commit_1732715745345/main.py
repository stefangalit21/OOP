import matplotlib.pyplot as plt
import numpy as np

# Data from the image
frequency = np.array([10, 60, 100, 200, 400, 800, 1000, 5000, 10000, 50000, 100000, 200000, 500000, 1000000])

ec_fara_ku = np.array([0.571, 2.86, 6.82, 15.6, 28.6, 39.6, 41.3, 46.8, 47.1, 46.6, 43.2, 36.2, 21, 16.4])
ec_reactie_ku = np.array([0.588, 1.55, 2.05, 2.8, 3.17, 0.3, 3.27, 3.29, 3.3, 3.32, 3.32, 3.29, 3.16, 3.62])
bc_ku = np.array([10.9, 34, 36.5, 38.5, 39, 39.3, 38.8, 39, 39.2, 39, 37.8, 34.1, 22.8, 18.5])
cc_ku = np.array([24.5, 25, 23, 22, 22.4, 21.8, 22.5, 22.2, 22.6, 21.9, 21.8, 21.7, 21.5, 21.9])

# Create the plot
plt.figure(figsize=(10, 6))

# Plotting each line
plt.plot(frequency, ec_fara_ku, label='EC fără reacție "Ku"', marker='o')
plt.plot(frequency, ec_reactie_ku, label='EC reacție negativă "Ku"', marker='s')
plt.plot(frequency, bc_ku, label='BC "Ku"', marker='^')
plt.plot(frequency, cc_ku, label='CC "Ku"', marker='d')

# Customizing the plot
plt.xlabel('Frecvență')
plt.ylabel('Valori')
plt.title('Grafic comparativ al datelor')
plt.xscale('log')  # Logarithmic scale for frequency
plt.legend()
plt.grid(True)

# Show the plot
plt.show()
