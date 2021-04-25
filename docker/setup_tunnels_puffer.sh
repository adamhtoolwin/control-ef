#!/bin/bash
ssh -fN -L 4125:localhost:4125 puffer
ssh -fN -L 9042:localhost:4126 puffer
