library identifier: 'INSSSharedLib', changelog: false

def playprefix = 'UKC'
def channel = '#operations'

def project = 'inss'

def gitmap = [
    [name: 'Repository', url: 'git@github.com:jameswarreninss/myrepotocheckout.git', poll: true, credentials: ''],
]

node('master') {
    cleanWs()
    StageLinearInOne ('ScmCheckout',gitmap)
}
