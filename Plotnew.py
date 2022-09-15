from matplotlib import pyplot as plt

plt.rcParams["figure.figsize"] = [7.00, 3.50]
plt.rcParams["figure.autolayout"] = True
x = [11, 10, 9, 8, 7, 6, 5, 4]
y = [0.3977444, 0.396, 0.39079, 0.3490, 0.360, 0.56, 0.48, 0.8]
plt.xlim(0, 12)
plt.ylim(0, 0.9)
plt.grid()
plt.plot(
    x, y, marker="o", markersize=20, markeredgecolor="red", markerfacecolor="green"
)
plt.xlabel("N size")
plt.ylabel("success probability")
plt.show()

# n=10, sample_count = 1000000, ans = 396737

# n = 9 ,sample_count=100000 , ans = 39079

# n = 8, sample_count=10000 ,ans=3490

# n=7,sample_count=1000,ans=360

# n=6,sample_coun=100,ans=56

# n=5,sample_count = 100,ans = 48

# n=4,sample_count = 20,ans=16
