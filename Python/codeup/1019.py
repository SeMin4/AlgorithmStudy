current = list(map(int, input().split('.')))
print("%04d." % current[0], end='')
print("%02d." % current[1], end='')
print("%02d" % current[2])