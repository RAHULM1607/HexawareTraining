package Day2Assignment;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class Task2Hashing {
    static class ClaimKey {
        String policyNumber;
        LocalDate incidentDate;

        ClaimKey(String policyNumber, LocalDate incidentDate) {
            this.policyNumber = policyNumber.replaceAll("\\s+", "").toLowerCase();
            this.incidentDate = incidentDate;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof ClaimKey)) return false;

            ClaimKey other = (ClaimKey) obj;
            return policyNumber.equals(other.policyNumber)
                    && incidentDate.equals(other.incidentDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(policyNumber, incidentDate);
        }
    }

    static class Claim {
        int claimId;
        String policyNumber;
        LocalDate incidentDate;

        Claim(int claimId, String policyNumber, LocalDate incidentDate) {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.incidentDate = incidentDate;
        }
    }

    static class DuplicateDetector {
        HashMap<ClaimKey, Claim> claims = new HashMap<>();

        void addClaim(Claim claim) {
            ClaimKey key = new ClaimKey(claim.policyNumber, claim.incidentDate);

            if (claims.containsKey(key)) {
                System.out.println("Duplicate claim detected! Claim ID: "
                        + claim.claimId + " matches Claim ID: "
                        + claims.get(key).claimId);
            } else {
                claims.put(key, claim);
                System.out.println("Claim " + claim.claimId + " registered.");
            }
        }
    }

    public static void main(String[] args) {
        DuplicateDetector detector = new DuplicateDetector();

        detector.addClaim(new Claim(101, "POLICY123",
                LocalDate.of(2026, 11, 10)));
        detector.addClaim(new Claim(102, "policy123",
                LocalDate.of(2026, 11, 10)));
        detector.addClaim(new Claim(103, "POLICY 123",
                LocalDate.of(2026, 11, 11)));
        detector.addClaim(new Claim(104, "POLICY123",
                LocalDate.of(2026, 11, 10)));
    }
}
