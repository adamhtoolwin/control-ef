#!/bin/bash
ssh -fN -L 4125:localhost:4125 guppy
ssh -fN -L 9042:localhost:4126 guppy
ssh -fN -L 7199:localhost:7199 guppy
ssh -fN -L 9160:localhost:9160 guppy

